class FilterController {
    /*
    * @filters: a list of all filters
    * @labelListRenderer: an object of class LabelListRenderer
    * 
    * this.activeFilters -> a Set that contains all active filters
    */
    constructor(filters, labelListRenderer) {
        this.filters = filters;
        this.labelListRenderer = labelListRenderer;

        this.activeFilters = new Set();
    }

    /*
    * initial setup (to render the initial state)
    */
    setup() {
        this.prepareRender();
    }

    /*
    * handles the logic of toggling a filter label.
    * @id: the id of the filter we need to toggle
    */
    toggleFilterById(id) {
        if(this.activeFilters.has(id)) {
            this.activeFilters.delete(id);
        } else {
            this.activeFilters.add(id);
        }

        this.prepareRender();
    }

    /*
    * creates a more format-frendly array for the label list renderer and it calls it.
    */
    prepareRender() {
        let convertedList = [];

        for(const filter of this.filters) {
            convertedList.push({
                ...filter,
                active: this.activeFilters.has(filter.id)
            });
        }

        this.notifyRenderer(convertedList);
    }

    /*
    * notifies the labelListRenderer that we have an update
    */
    notifyRenderer(convertedList) {
        this.labelListRenderer.render(convertedList);
    }

    /*
    * This function gets an array of labels and determines wheter a projects that has this list
    * should be shown on the webpage
    */
    shouldInclude(labelsArray) {
        if(this.activeFilters.size == 0) { // not filters applied, it's good to go
            return true;
        }

        for(const { id } of labelsArray) {
            if(this.activeFilters.has(id)) {
                return true;
            }
        }

        return false;
    }
}