let tours;

function fetchTours() {
    const url = "http://localhost:8080/api/get-tours";
    fetch(url).then(response => response.json()).then(data => {tours = data; listTours(data)});

}

function listTours(tours) {
    document.getElementById("tours-container").innerHTML = "";
    for (let tour of tours) {

        let col = document.createElement("div");
        col.setAttribute("class", "col-sm-4");

        let card = document.createElement("div");
        card.setAttribute("class", "card");

        let cardBody = document.createElement("div");
        cardBody.setAttribute("class", "card-body");

        let tourName = document.createElement("h4");
        let tourNameText = document.createTextNode(tour.tourName);
        tourName.setAttribute("class", "card-title");
        tourName.appendChild(tourNameText);

        let description = document.createElement("p");
        let descriptionText = document.createTextNode(tour.description);
        description.setAttribute("class", "card-text");
        description.appendChild(descriptionText);

        let infoButton = document.createElement("a");
        infoButton.setAttribute("href", "http://localhost:8080/tour-admin/" + tour.id);
        infoButton.setAttribute("class", "btn btn-primary");
        let buttonText = document.createTextNode("Edit");
        infoButton.appendChild(buttonText);

        let deleteButton = document.createElement("button");
        deleteButton.setAttribute("id", tour.id);
        deleteButton.setAttribute("class", "btn btn-danger");
        let deleteButtonText = document.createTextNode("Delete");
        deleteButton.addEventListener("click", deleteTour);
        deleteButton.appendChild(deleteButtonText);

        document.getElementById("tours-container").appendChild(col);
        col.appendChild(card);
        card.appendChild(cardBody);
        cardBody.appendChild(tourName);
        cardBody.appendChild(description);
        cardBody.appendChild(infoButton);
        cardBody.appendChild(deleteButton);

    }
}

function deleteTour(event) {
    const tourToDelete = event.target.id;
    let deleteRequest = {
        method: "DELETE",
    }

    let url = "http://localhost:8080/api/delete-tour/" + tourToDelete;

    fetch(url, deleteRequest).then(data => {fetchTours()});
}