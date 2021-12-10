const reservation = JSON.parse(sessionStorage.getItem("reservation"));

document.getElementById("tour-name").innerText += reservation.tour.tourName;

const reservedDate = new Date(reservation.reservedDateAndTime);
const reservedDateString = reservedDate.toLocaleDateString() + " kl. " + reservedDate.toLocaleTimeString();
document.getElementById("reserved-time").innerText += reservedDateString;

const startDate = new Date(reservation.startDateAndTime);
const startDateString = startDate.toLocaleDateString() + " kl. " + startDate.toLocaleTimeString();
document.getElementById("start-date").innerText += startDateString;

const endDate = new Date(reservation.endDateAndTime);
const endDateString = endDate.toLocaleDateString() + " kl. " + endDate.toLocaleTimeString();
document.getElementById("end-date").innerText += endDateString;

document.getElementById("passenger-amount").innerText += reservation.numberOfPassengers;

document.getElementById("price").innerText += reservation.priceAtReservedTime;

const numberOfPassengers = parseInt(reservation.numberOfPassengers);
const price = parseInt(reservation.priceAtReservedTime);
const totalPrice = numberOfPassengers * price;
document.getElementById("total-price").innerText += totalPrice;

