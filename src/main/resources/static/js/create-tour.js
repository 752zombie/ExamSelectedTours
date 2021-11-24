function postTour() {
    console.log("test")
    const tourName = document.getElementById("tour-name").value;
    const price = document.getElementById("price").value;
    const description = document.getElementById("description").value;

    const tour = {
        tourName : tourName,
        description : description,
        price : price
    }

    const tourJSON = JSON.stringify(tour);

    let postRequest = {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: tourJSON
    }

    fetch("http://localhost:8080/api/create-tour", postRequest).then(response => { if (!response.ok) throw new Error("Network error");
    return response.json(); }).
    then(data => displaySuccess()).catch(error => displayError());

}

function displaySuccess() {
    document.getElementById("result").innerText = "Success: tour has been created";
    document.getElementById("result").style.display = "block";
}

function displayError() {
    document.getElementById("result").innerText = "Error: something went wrong";
    document.getElementById("result").style.display = "block";
}