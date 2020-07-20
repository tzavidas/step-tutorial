class ProjectController {
    /*
    * @projects: a list of all projects
    * @filterController: an object of class FilterController
    * @mainContentRenderer: an object of class MainContentRenderer
    */
    constructor(projects, filterController, mainContentRenderer) {
        this.projects = projects;
        this.mainContentRenderer = mainContentRenderer;

        this.filterController = filterController;
    }
    
    /*
    * initial setup (to render the initial state)
    */
    setup() {
        this.notifyRenderer();
    }

    /*
    * notifies the mainContentRenderer that we have an update
    */
    notifyRenderer() {
        this.mainContentRenderer.render(this.projects);
    }

    /*
    * updates the attribute "active" of all the projects
    */
    updateActiveStatusOfProjects() {
        for(const project of this.projects) {
            project.active = this.filterController.shouldInclude(project.labels);
        }

        this.notifyRenderer();
    }

    /*
    * applies sorting to the project list
    * @by: the attribute we need to sort by
    * @type: asecnding or descending sort
    */
    applySorting(by, type) {
        if(!["asc", "desc"].includes(type)) {
            throw IllegalTypeParameter;
        }

        if(!["title", "date"].includes(by)) {
            throw IllegalByParameter;
        }

        // For more details on how this work, check
        // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort
        this.projects.sort((left, right) => {
            let evaluation = (left[by] < right[by] ? -1 : 1);

            if(type == "desc") { // reverse the order
                evaluation = -evaluation;
            }

            return evaluation;
        });

        this.notifyRenderer();
    }
}