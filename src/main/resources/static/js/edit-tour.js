let tour;

function getTour() {
    let url = "http://localhost:8080/api/get-tour/";
    const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1);
    url = url + id;
    const prom = fetch(url).then(data => data.json());
    prom.then(json => {tour = json; displayTour()});
}

function displayTour() {
    //insert tour info into input fields
    document.getElementById("tour-name").value = tour.tourName;
    document.getElementById("price").value = tour.price;
    document.getElementById("description").value = tour.description;
    document.getElementById("duration").value = tour.durationDays;
}

function saveTour() {
    tour.tourName = document.getElementById("tour-name").value;
    tour.price = document.getElementById("price").value;
    tour.description = document.getElementById("description").value;
    tour.durationDays = document.getElementById("duration").value;

    const url = "http://localhost:8080/api/save-tour"

    let saveTourRequest = {
        method: "PUT",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify(tour)
    }

    fetch(url, saveTourRequest).then(response => { if (!response.ok) throw new Error("Network error");
        return response.json(); }).
    then(data => displaySuccess()).catch(error => displayError());

}

function discardChanges() {
    displayTour();
}

function displaySuccess() {
    document.getElementById("result").innerText = "Success: tour has been saved";
    document.getElementById("result").style.display = "block";
}

function displayError() {
    document.getElementById("result").innerText = "Error: something went wrong";
    document.getElementById("result").style.display = "block";
}