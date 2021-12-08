let tours;

function fetchTours() {
    console.log(1);
    const url = "http://localhost:8080/api/get-tours";
    fetch(url).then(response => response.json()).then(data => {tours = data; listTours(data)});
    console.log(2);

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

        let label = document.createElement("p");
        let labelText = document.createTextNode("Antal billetter: ");
        label.setAttribute("class", "card-text");
        label.appendChild(labelText);

        let reserveForm = document.createElement("form");
        reserveForm.setAttribute("method", "post")
        reserveForm.setAttribute("action", "http://localhost:8080/reserve_tour/")
        let ticketsInput = document.createElement("input");
        ticketsInput.setAttribute("class", "form-control")
        ticketsInput.style.width = "70px";
        ticketsInput.style.marginBottom = "5px";
        ticketsInput.setAttribute("type", "number");
        ticketsInput.setAttribute("name", "numberOfTickets");
        ticketsInput.setAttribute("value", ticketsInput.innerHTML);



        let reserveInput = document.createElement("input");
        reserveInput.setAttribute("type", "hidden");
        reserveInput.setAttribute("name", "id");
        reserveInput.setAttribute("value", tour.id);
        let reserveButton = document.createElement("button")
        reserveButton.setAttribute("type", "submit");
        reserveButton.setAttribute("class", "btn btn-primary");
        let buttonText = document.createTextNode("Reserver");

        reserveButton.appendChild(buttonText);
        reserveForm.appendChild(reserveInput);
        reserveForm.appendChild(ticketsInput);
        reserveForm.appendChild(reserveButton);

        document.getElementById("tours-container").appendChild(col);
        col.appendChild(card);
        card.appendChild(cardBody);
        cardBody.appendChild(tourName);
        cardBody.appendChild(description);
        cardBody.appendChild(labelText);
        cardBody.appendChild(reserveForm);


    }
}

