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
        labels: [],
        active: true
    }, {
        title: "My 3rd",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat2.jpg",
        labels: [],
        active: true
    }, {
        title: "My 4th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat1.jpg",
        labels: [],
        active: true
    }, {
        title: "My 5th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat2.jpg",
        labels: [],
        active: true
    }, {
        title: "My 6th",
        description: "Lorem Ipsum",
        imageUrl: "/images/cat1.jpg",
        labels: [],
        active: true
    }, {
        title: "My 7th",
        description: "Lorem Ipsum LASTTTT",
        imageUrl: "/images/cat2.jpg",
        labels: [],
        active: true
    }];

    const labels = [{
        name: "C++",
        color: "red"
    }, {
        name: "Java",
        color: "green"
    }, {
        name: "Python",
        color: "black"
    }, {
        name: "JavaScript",
        color: "blue"
    }];

    labelListRenderer.render(labels);
    mainContentRenderer.render(projects);
}