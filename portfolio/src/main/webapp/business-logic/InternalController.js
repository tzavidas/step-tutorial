// Class that acts as the entry point of our business logic application section
// in a similar way to a facade
class InternalController {
    constructor(projectController, filterController) {
        this.projectController = projectController;
        this.filterController = filterController;

        this.setup();
    }

    /*
    * initial setup (to render the initial state)
    */
    setup() {
        this.projectController.setup();
        this.filterController.setup();
    }

    /*
    * delegates actions to toggle the appropriate filter
    * @filterId: the id of the filter we need to toggle
    */
    toggleFilter(filterId) {
        this.filterController.toggleFilterById(filterId);

        this.projectController.updateActiveStatusOfProjects(this.filterController.getAllFilters());
    }

    /*
    * delegates actions to apply sorting
    * @by: the attribute we need to sort by
    * @type: asecnding or descending sort
    */
    applySorting(by, type) {
        this.projectController.applySorting(by, type);
    }
}