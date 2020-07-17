// function to test the functionality of our business logic
// it will be reused partially on deployment
const test = () => {
    const labelsListElement = document.getElementsByClassName("labels-list")[0];
    const projectContainerElement = document.getElementsByClassName("project-container")[0];

    const labelListRenderer = new LabelListRenderer(labelsListElement);
    const mainContentRenderer = new MainContentRenderer(projectContainerElement);

    const projects = [{
        title: "My first",
        description: "My desc",
        imageUrl: "/images/cat1.jpg",
        labels: [],
        active: true
    }, {
        title: "My second",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat2.jpg",
        labels: [{
            id: 1,
            name: "C++",
            color: "red"
        }, {
            id: 2,
            name: "Java",
            color: "green"
        }, {
            id: 3,
            name: "Python",
            color: "black"
        }, {
            id: 4,
            name: "JavaScript",
            color: "blue"
        }],
        active: true
    }, {
        title: "My 3rd",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat2.jpg",
        labels: [{
            id: 1,
            name: "C++",
            color: "red"
        }, {
            id: 4,
            name: "JavaScript",
            color: "blue"
        }],
        active: true
    }, {
        title: "My 4th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat1.jpg",
        labels: [{
            id: 2,
            name: "Java",
            color: "green"
        }, {
            id: 3,
            name: "Python",
            color: "black"
        }, {
            id: 4,
            name: "JavaScript",
            color: "blue"
        }],
        active: true
    }, {
        title: "My 5th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat2.jpg",
        labels: [{
            id: 3,
            name: "Python",
            color: "black"
        }],
        active: true
    }, {
        title: "My 6th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat1.jpg",
        labels: [{
            id: 1,
            name: "C++",
            color: "red"
        }, {
            id: 3,
            name: "Python",
            color: "black"
        }, {
            id: 4,
            name: "JavaScript",
            color: "blue"
        }],
        active: true
    }, {
        title: "My 7th",
        description: "Lorem Ipsum LASTTTT",
        imageUrl: "/images/cat2.jpg",
        labels: [],
        active: true
    }];

    const labels = [{
        id: 1,
        name: "C++",
        color: "red"
    }, {
        id: 2,
        name: "Java",
        color: "green"
    }, {
        id: 3,
        name: "Python",
        color: "black"
    }, {
        id: 4,
        name: "JavaScript",
        color: "blue"
    }];

    const filterController = new FilterController(labels, labelListRenderer);
    const projectController = new ProjectController(projects, filterController, mainContentRenderer);
    const internalController = new InternalController(projectController, filterController);

    //labelListRenderer.render(labels);
    //mainContentRenderer.render(projects);
    internalController.setup();
}