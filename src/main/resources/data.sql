-- Create sample movie only if not already present
INSERT INTO movies (title, description, poster_url)
SELECT 'Demon Slayer',
       'Demon Slayer: Kimetsu no Yaiba is a Japanese manga series written and illustrated by Koyoharu Gotouge. It was serialized in Shueisha\'s shōnen manga magazine Weekly Shōnen Jump from February 2016 to May 2020, with its chapters collected in 23 tankōbon volumes',
       'https://res.cloudinary.com/drs9pl7fr/image/upload/v1762683086/wallpaperflare.com_wallpaper_-_Copy_eoejkf.jpg'
WHERE NOT EXISTS (SELECT 1 FROM movies WHERE title = 'Demon Slayer');

-- Insert showtime only if not exists for that movie
INSERT INTO showtimes (movie_id, start_time, seat_price)
SELECT m.id, '7:00 PM', 150.0
FROM movies m
WHERE m.title = 'Demon Slayer'
  AND NOT EXISTS (
      SELECT 1 FROM showtimes s WHERE s.movie_id = m.id AND s.start_time = '7:00 PM'
  );

-- Insert seats (A1–A10) idempotently
INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A1', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A1' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A2', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A2' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A3', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A3' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A4', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A4' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A5', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A5' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A6', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A6' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A7', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A7' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A8', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A8' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A9', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A9' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A10', 'A', false FROM showtimes s
WHERE s.start_time = '7:00 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A10' AND showtime_id = s.id);

INSERT INTO movies (title, description, poster_url)
SELECT 'Interstellar',
       'Explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.',
       'https://images.unsplash.com/photo-1457369804613-52c61a468e7d?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM movies WHERE title = 'Interstellar');

INSERT INTO showtimes (movie_id, start_time, seat_price)
SELECT m.id, '4:30 PM', 180.0
FROM movies m
WHERE m.title = 'Interstellar'
  AND NOT EXISTS (
      SELECT 1 FROM showtimes s WHERE s.movie_id = m.id AND s.start_time = '4:30 PM'
  );

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A1', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A1' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A2', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A2' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A3', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A3' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A4', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A4' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A5', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A5' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A6', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A6' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A7', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A7' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A8', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A8' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A9', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A9' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A10', 'A', false FROM showtimes s
WHERE s.start_time = '4:30 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A10' AND showtime_id = s.id);

INSERT INTO movies (title, description, poster_url)
SELECT 'Jailer',
       'A retired jailer goes on a mission to hunt down a criminal mastermind.',
       'https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM movies WHERE title = 'Jailer');

INSERT INTO showtimes (movie_id, start_time, seat_price)
SELECT m.id, '9:15 PM', 200.0
FROM movies m
WHERE m.title = 'Jailer'
  AND NOT EXISTS (
      SELECT 1 FROM showtimes s WHERE s.movie_id = m.id AND s.start_time = '9:15 PM'
  );

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A1', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A1' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A2', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A2' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A3', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A3' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A4', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A4' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A5', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A5' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A6', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A6' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A7', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A7' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A8', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A8' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A9', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A9' AND showtime_id = s.id);

INSERT INTO seats (showtime_id, seat_number, row_no, booked)
SELECT s.id, 'A10', 'A', false FROM showtimes s
WHERE s.start_time = '9:15 PM'
  AND NOT EXISTS (SELECT 1 FROM seats WHERE seat_number = 'A10' AND showtime_id = s.id);


-- Add more seats as needed
