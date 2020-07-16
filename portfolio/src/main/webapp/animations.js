const getParentCardElement = (el) => {
    while(!el.classList.contains("card")) {
        el = el.parentElement;
    }

    return el;
}

const flipCard = (currElement) => {
    const cardElement = getParentCardElement(currElement);

    if(cardElement.classList.contains("card-flipped")) { // is already flipped
        cardElement.classList.remove("card-flipped");
    } else {
        cardElement.classList.add("card-flipped");
    }
}
