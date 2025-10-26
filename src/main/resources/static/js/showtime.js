javascript
// Showtime Selection Logic

document.addEventListener('DOMContentLoaded', function() {
    initializeShowtimeSelection();
    initializeDatePicker();
    initializeTheaterFilter();
});

// Initialize showtime selection
function initializeShowtimeSelection() {
    const showtimeButtons = document.querySelectorAll('.showtime-btn');
    
    showtimeButtons.forEach(button => {
        button.addEventListener('click', function() {
            const showId = this.dataset.showId;
            const availableSeats = parseInt(this.dataset.availableSeats);
            
            if (availableSeats <= 0) {
                alert('This show is fully booked!');
                return;
            }
            
            // Remove active class from all buttons
            showtimeButtons.forEach(btn => btn.classList.remove('active'));
            
            // Add active class to clicked button
            this.classList.add('active');
            
            // Store selected show in session
            sessionStorage.setItem('selectedShowId', showId);
            
            // Enable proceed button
            const proceedBtn = document.getElementById('proceedToSeats');
            if (proceedBtn) {
                proceedBtn.disabled = false;
                proceedBtn.href = `/booking/seats/${showId}`;
            }
        });
    });
}

// Date picker for show selection
function initializeDatePicker() {
    const dateButtons = document.querySelectorAll('.date-btn');
    
    dateButtons.forEach(button => {
        button.addEventListener('click', function() {
            const selectedDate = this.dataset.date;
            
            // Remove active class from all date buttons
            dateButtons.forEach(btn => btn.classList.remove('active'));
            
            // Add active class to clicked button
            this.classList.add('active');
            
            // Filter shows by date
            filterShowsByDate(selectedDate);
        });
    });
}

// Filter shows by selected date
function filterShowsByDate(date) {
    const showCards = document.querySelectorAll('.show-card');
    
    showCards.forEach(card => {
        const showDate = card.dataset.showDate;
        
        if (date === 'all' || showDate === date) {
            card.style.display = 'block';
            card.classList.add('fade-in');
        } else {
            card.style.display = 'none';
        }
    });
}

// Theater filter
function initializeTheaterFilter() {
    const theaterSelect = document.getElementById('theaterFilter');
    
    if (theaterSelect) {
        theaterSelect.addEventListener('change', function() {
            const selectedTheater = this.value;
            filterShowsByTheater(selectedTheater);
        });
    }
}

// Filter shows by theater
function filterShowsByTheater(theaterId) {
    const showCards = document.querySelectorAll('.show-card');
    
    showCards.forEach(card => {
        const cardTheaterId = card.dataset.theaterId;
        
        if (theaterId === 'all' || cardTheaterId === theaterId) {
            card.style.display = 'block';
        } else {
            card.style.display = 'none';
        }
    });
}

// Generate date buttons for next 7 days
function generateDateButtons() {
    const dateContainer = document.getElementById('dateContainer');
    if (!dateContainer) return;
    
    const today = new Date();
    const dateButtons = [];
    
    for (let i = 0; i < 7; i++) {
        const date = new Date(today);
        date.setDate(today.getDate() + i);
        
        const dateStr = date.toISOString().split('T')[0];
        const dayName = date.toLocaleDateString('en-US', { weekday: 'short' });
        const dayNum = date.getDate();
        const monthName = date.toLocaleDateString('en-US', { month: 'short' });
        
        const button = `
            <button class="date-btn ${i === 0 ? 'active' : ''}" data-date="${dateStr}">
                <div class="date-day">${dayName}</div>
                <div class="date-num">${dayNum}</div>
                <div class="date-month">${monthName}</div>
            </button>
        `;
        
        dateButtons.push(button);
    }
    
    dateContainer.innerHTML = dateButtons.join('');
    initializeDatePicker();
}

// Format time display
function formatShowTime(dateTimeString) {
    const date = new Date(dateTimeString);
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const ampm = hours >= 12 ? 'PM' : 'AM';
    const displayHours = hours % 12 || 12;
    const displayMinutes = minutes.toString().padStart(2, '0');
    
    return `${displayHours}:${displayMinutes} ${ampm}`;
}

// Check show availability
function checkShowAvailability(showId) {
    fetch(`/api/shows/${showId}/availability`)
        .then(response => response.json())
        .then(data => {
            const button = document.querySelector(`[data-show-id="${showId}"]`);
            if (button) {
                button.dataset.availableSeats = data.availableSeats;
                
                if (data.availableSeats <= 0) {
                    button.classList.add('sold-out');
                    button.disabled = true;
                } else if (data.availableSeats <= 10) {
                    button.classList.add('filling-fast');
                }
            }
        })
        .catch(error => {
            console.error('Error checking availability:', error);
        });
}

// Auto-refresh show availability every 30 seconds
setInterval(() => {
    const showtimeButtons = document.querySelectorAll('.showtime-btn');
    showtimeButtons.forEach(button => {
        const showId = button.dataset.showId;
        checkShowAvailability(showId);
    });
}, 30000);