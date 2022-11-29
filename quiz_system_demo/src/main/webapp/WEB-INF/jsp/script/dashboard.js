const hashPageRequest = (pageNum) => {
    const content = document.getElementsByClassName("content");
    content[pageNum].style.display = "block";
    const numPages = content.length;
    for (let i = 0; i < numPages; i++) {
        if (i !== pageNum) {
            content[i].style.display = "none";
        }
    }
};

// reloads the page base on the hash value
const hashPageReload = () => {
    const hash = window.location.hash;
    if (hash === "quiz") {
        hashPageRequest(1);
    } else if (hash === "database") {
        hashPageRequest(2);
    } else if (hash === "user") {
        hashPageRequest(3);
    } else {
        hashPageRequest(0);
    }
};

hashPageReload();
