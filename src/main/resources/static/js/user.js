let body;
let postRequest = {
    method: "POST",
    headers: {
        "content-type": "application/json",
        'Accept': 'application/json'
    },
    body: body
}
let user;
function fetchUser() {
    const url = "http://localhost:8080/api/createUser";
    const prom = fetch(url).then(data => data.json());
    prom.then(json => {user = json; createUser(user)});
}
function createUser() {
    document.getElementById("create-user").style.display = "block";

}
function login() {
    document.getElementById("login").style.display = "block";
}
function saveUser() {
    document.getElementById("create-user").style.display = "none";

    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var role = document.getElementById("role").value;
    var save_user_input = confirm('Save user information');

    if (save_user_input == null) {
        alert("cancelled");
    } else {
        const data = JSON.stringify({
            firstName: firstName,
            lastName: lastName,
            password: password,
            email: email,
            role: role,
        })

        const xhr = new XMLHttpRequest()
        xhr.withCredentials = true

        xhr.addEventListener('readystatechange', function () {
            if (this.readyState === this.DONE) {
                console.log(this.responseText)
            }
        })

        xhr.open('POST', 'api/createUser')
        xhr.setRequestHeader('content-type', 'application/json')
        xhr.send(data)
        alert(save_user_input + " information saved!");
        refresh()
    }

    }
function refresh() {
    document.getElementById("create-user").innerHTML = "";
    fetchUser();
}

let userLogin = {
    "firstName": "",
    "password": "",
}
let postUserUrl = "http://localhost:8080/createUser";
let loginApiUrl = "http://localhost:8080/api/userLogin";
function startLogin() {
    document.getElementById("login").style.display = "none";
    let firstName = inpGetUser[0].value;
    let password = inpGetUser[1].value;
    console.log(firstName + "from login")
    userLogin.firstName = firstName;
    userLogin.password = password;
    body = JSON.stringify(userLogin);
    postRequest.body = body;
    fetch(loginApiUrl, postRequest)
        .then(response => response.json())
        .then(loginSuccess => {
            if (loginSuccess) {
                window.location.href = "http://localhost:8080/create-tour";
            }

            else {
                alert('Wrong username / firstname');
            }


        })
        .catch(error => alert('Wrong username / firstname'));


}

const inpGetUser = document.querySelectorAll(".userInfo");
const pbGetLogin = document.querySelector(".pbGet");

pbGetLogin.addEventListener('click', startLogin);
