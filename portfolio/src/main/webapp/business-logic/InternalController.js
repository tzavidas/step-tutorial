class InternalController {
    constructor(projectController, filterController) {
        this.projectController = projectController;
        this.filterController = filterController;

        this.setup();
    }

    setup() {
        this.projectController.setup();
        this.filterController.setup();
    }

    toggleFilter(filterId) {
        this.filterController.toggleFilterById(filterId);

        this.projectController.updateActiveProjects(this.filterController.getAllFilters());
    }

    applySorting(by, type) {
        this.projectController.applySorting(by, type);
    }
}