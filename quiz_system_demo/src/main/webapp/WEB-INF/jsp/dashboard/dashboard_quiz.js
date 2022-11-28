const changeIcon = (anchor) => {
    const icon = anchor.querySelector("i");
    if (icon.classList.contains("bi-x-circle")) {
        icon.classList.remove("bi-x-circle");
        icon.classList.add("bi-check-circle");
    } else {
        icon.classList.remove("bi-check-circle");
        icon.classList.add("bi-x-circle");
    }
    //   icon.classList.toggle("bi-x-circle");
    //   icon.classList.toggle("bi-check-circle");
};

const addUser = () => {
    const numberOfUsers = document.getElementsByTagName("tr").length;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const address = document.getElementById("address").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const formItems = document.getElementsByClassName("addUserForm")[0];
    for (let i = 0; i < formItems.length; i++) {
        formItems[i].value = "";
    }
    const tableString =
        "<tr class='text-center'><th scope='row'>" +
        numberOfUsers +
        "</th><td>" +
        firstName +
        "</td><td>" +
        lastName +
        "</td><td>" +
        address +
        "</td><td>" +
        email +
        "</td><td>" +
        phone +
        "</td><td><a class='editStatus' title='EditStatus' data-toggle='tooltip' onClick='changeIcon(this)'><i class='bi bi-x-circle text-dark'></i></a></td><td><a class='edit me-2' title='Edit' data-toggle='tooltip' data-bs-toggle='modal' data-bs-target='#editUserModal'><i class='bi bi-pencil-square text-dark'></i></a><a class='delete' title='Delete' data-toggle='tooltip' onClick='deleteRow(this)'><i class='bi bi-person-dash text-dark'></i></a></td></tr>";
    // find tbody and append tableString to it
    document
        .getElementsByTagName("tr")
        [numberOfUsers - 1].insertAdjacentHTML("afterend", tableString);
    // reset form
};

const deleteRow = (anchor) => {
    const id = anchor.closest("tr").getElementsByTagName("th")[0].innerHTML;
    console.log(id);
    anchor.closest("tr").remove();
};
