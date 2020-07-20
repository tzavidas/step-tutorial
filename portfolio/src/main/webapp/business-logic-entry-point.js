const handleLabelClick = (filterId) => {
    document.internalControllerGlobalObject.toggleFilter(filterId);
};

const getValueOfSortTypeRadio = () => {
    const radioElements = document.getElementsByName("sort-type");

    for(const currRadio of radioElements) {
        if(currRadio.checked) {
            return currRadio.value;
        }
    }

    return "asc"; // ascending by default
}

const handleSelectChange = () => {
    const sortBy = document.getElementsByName("sort-attribute")[0].value;

    if(sortBy) { // not empty
        const sortType = getValueOfSortTypeRadio();

        document.internalControllerGlobalObject.applySorting(sortBy, sortType);
    }
}