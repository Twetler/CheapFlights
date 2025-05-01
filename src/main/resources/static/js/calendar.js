// Confirm it's loading
window.alert("Calendar Loaded");

// DOM elements
const calendarDates = document.querySelector('.calendar-dates');
const monthYear = document.getElementById('month-year');
const prevMonthBtn = document.getElementById('prev-month');
const nextMonthBtn = document.getElementById('next-month');

let currentDate = new Date();
let currentMonth = currentDate.getMonth();
let currentYear = currentDate.getFullYear();

const months = [
  'January', 'February', 'March', 'April', 'May', 'June',
  'July', 'August', 'September', 'October', 'November', 'December'
];

function renderCalendar(month, year) {
  calendarDates.innerHTML = '';
  monthYear.textContent = `${months[month]} ${year}`;

  // Get the first day of the month (0 = Sunday)
  const firstDay = new Date(year, month, 1).getDay();

  // Number of days in the month
  const daysInMonth = new Date(year, month + 1, 0).getDate();

  // Fill empty grid cells before first day
  for (let i = 0; i < firstDay; i++) {
    const empty = document.createElement('div');
    empty.className = 'calendar-day empty';
    calendarDates.appendChild(empty);
  }

  // Fill the calendar with days
  for (let i = 1; i <= daysInMonth; i++) {
    const day = document.createElement('div');
    day.className = 'calendar-day border rounded text-center p-2';
    day.textContent = i;
    calendarDates.appendChild(day);
  }
}

// Event listeners for month navigation
prevMonthBtn.addEventListener('click', () => {
  if (currentMonth === 0) {
    currentMonth = 11;
    currentYear--;
  } else {
    currentMonth--;
  }
  renderCalendar(currentMonth, currentYear);
});

nextMonthBtn.addEventListener('click', () => {
  if (currentMonth === 11) {
    currentMonth = 0;
    currentYear++;
  } else {
    currentMonth++;
  }
  renderCalendar(currentMonth, currentYear);
});

// Initial render
renderCalendar(currentMonth, currentYear);
