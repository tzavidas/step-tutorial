let isMenuOpen = false;

const openMenu = () => {
    const menu = document.getElementsByClassName("menu")[0];
    const concealLayer = document.getElementsByClassName("content-conceal-layer")[0];
    
    menu.classList.add("menu-open");

    concealLayer.classList.add("content-conceal-layer-active");

    isMenuOpen = true;
}

const closeMenu = () => {
    const menu = document.getElementsByClassName("menu")[0];
    const concealLayer = document.getElementsByClassName("content-conceal-layer")[0];
    
    menu.classList.remove("menu-open");

    concealLayer.classList.remove("content-conceal-layer-active");

    isMenuOpen = false;    
}

const menuToggle = () => {
    if(isMenuOpen) {
        closeMenu();
    } else {
        openMenu();
    }
}

const handleConcealLayerClick = (e) => {
    closeMenu();
}

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
