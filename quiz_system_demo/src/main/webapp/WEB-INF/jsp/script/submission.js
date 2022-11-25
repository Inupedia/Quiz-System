const showTab = (n, m) => {
    // if the score over 50% then show the next tab
    if (n / m < 0.5) {
        const retakeBtn = document.getElementById("retakeBtn");
        retakeBtn.style.display = "inline";
    }

}
