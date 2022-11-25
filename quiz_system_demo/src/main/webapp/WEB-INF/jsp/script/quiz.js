const showTab = (n) => {
    // This function will display the specified tab of the form ...
    const x = document.getElementsByClassName("tab");
    x[n].style.display = "block";
    // ... and fix the Previous/Next buttons:
    if (n === 0) {
        document.getElementById("prevBtn").style.display = "none";
    } else {
        document.getElementById("prevBtn").style.display = "inline";
    }
    if (n === (x.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Submit";
    } else {
        document.getElementById("nextBtn").innerHTML = "Next";
    }
    // ... and run a function that displays the correct step indicator:
    fixStepIndicator(n)
}

const nextPrev = (n) => {
    // This function will figure out which tab to display
    const x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (n === 1 && !validateForm()) return false;
    // Hide the current tab:
    x[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form...
    if (currentTab >= x.length) {
        // ... the form gets submitted:
        document.getElementById("nextBtn").type = "submit";
        return false;
    }
    // Otherwise, display the correct tab:
    showTab(currentTab);
}

const validateForm = () => {
    // This function deals with validation of the form fields
    const x = document.getElementsByClassName("tab");
    const y = x[currentTab].getElementsByTagName("input");
    // A loop that checks answer is selected or not:
    let valid = false;
    for (let i = 0; i < y.length; i++) {
        valid = y[i].checked;
        if (valid) {
            break;
        }
    }
    // If the valid status is true, mark the step as finished and valid:
    if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
    }
    return valid; // return the valid status
}

const fixStepIndicator = (n) => {
    // This function removes the "active" class of all steps...
    const x = document.getElementsByClassName("step");
    for (let i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
    }
    //... and adds the "active" class to the current step:
    x[n].className += " active";
}


let currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab