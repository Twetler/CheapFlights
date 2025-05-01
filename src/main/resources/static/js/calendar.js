console.log("Calendar Loaded");

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

function isSameDay(date1, date2) {
    return (
      date1.getFullYear() === date2.getFullYear() &&
      date1.getMonth() === date2.getMonth() &&
      date1.getDate() === date2.getDate()
    );
}

function renderCalendar(month, year, flightDates) {
    flightDates = flightDates.map(dateStr => new Date(dateStr));
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
    
        // Create a Date object for this day
        const dateToCheck = new Date(year, month, i);
    
        // Check if it's in the list of flight dates
        if (flightDates.some(flightDate => isSameDay(flightDate, dateToCheck))) {
            day.classList.add('bg-warning', 'text-dark', 'fw-bold');
        }
    
        calendarDates.appendChild(day);
    }
    
}

// Event listeners
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

calendarDates.addEventListener('click', (e) => {
    if (e.target.textContent !== '') {
      alert(`You clicked on ${e.target.textContent} ${months[currentMonth]} ${currentYear}`);
      console.log(e);
    }
  });

// Initial render
renderCalendar(currentMonth, currentYear, flightDates);
console.log(flightDates);
