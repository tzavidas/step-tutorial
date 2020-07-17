class ProjectController {
    constructor(projects, filterController, mainContentRenderer) {
        this.projects = projects;
        this.mainContentRenderer = mainContentRenderer;

        this.filterController = filterController;
    }
    
    setup() {
        this.notifyRenderer();
    }

    notifyRenderer() {
        this.mainContentRenderer.render(this.projects);
    }

    updateActiveProjects(filter) {
        for(project of projects) {
            currLabel.active = this.filterController.shouldIncude(project.labels);
        }

        this.notifyRenderer();
    }

    applySorting(by, type) {
        if(!["asc", "desc"].includes(type)) {
            throw IllegalTypeParameter;
        }

        if(!["title", "date"].includes(by)) {
            throw IllegalByParameter;
        }

        this.projects.sort((left, right) => {
            let evaluation = right[by] - left[by];

            if(by == "desc") { // reverse the order
                evaluation = -eval;
            }

            return evaluation;
        });

        this.notifyRenderer();
    }
}