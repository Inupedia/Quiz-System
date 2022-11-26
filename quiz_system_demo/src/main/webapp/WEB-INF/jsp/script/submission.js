const showTab = (n, m) => {
    // if the score over 50% then show the next tab
    if (n / m <= 0.5) {
        const retakeBtn = document.getElementById("retakeBtn");
        retakeBtn.style.display = "inline";
    }

}

const showResults = (n, m) => {
    const res = document.getElementsByClassName("result-board");
    const p = res[0].getElementsByTagName("p");
    if (n / m <= 0.5) {
        p[0].innerHTML = "You have failed the quiz, please try again.";
    } else {
        p[0].innerHTML = "You have passed the quiz, congratulations!";
    }
}

const retake = (quizId) => {
    const retakeBtn = document.getElementById("retakeBtn");
    // add the event listener to the retake button, redirect to the quiz page: quiz?quizTypeId=quizId
    window.location.href = "/quiz?quizTypeId=" + quizId;
}

const submitFeedback = (quizId) => {
    const feedbackBtn = document.getElementById("feedbackBtn");
    // add the event listener to the feedback button, redirect to the feedback page: feedback
    window.location.href = "/feedback?quizTypeId=" + quizId;
}