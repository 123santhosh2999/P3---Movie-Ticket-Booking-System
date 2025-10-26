javascript
// Seat Selection Logic

let selectedSeats = [];

function toggleSeat(button) {
    const seatId = button.id;
    
    if (button.classList.contains('selected')) {
        button.classList.remove('selected');
        selectedSeats = selectedSeats.filter(s => s !== seatId);
    } else {
        button.classList.add('selected');
        selectedSeats.push(seatId);
    }
    
    updateBookingSummary();
}

function updateBookingSummary() {
    const totalSeatsEl = document.getElementById('totalSeats');
    const totalAmountEl = document.getElementById('totalAmount');}