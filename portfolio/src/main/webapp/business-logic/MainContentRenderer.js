// Renders the HTML card on the main content
class MainContentRenderer extends RendererInterface {
    /*
    * @param targetElement -> the appropriate DOM element
    */
    constructor(targetElement) {
        super();

        this.target = targetElement;
    }

    /*
    * Helper function that creates the HMTL for a given label.
    * @label the label object that will be used
    */
    createLabel(label) {
        return `
            <div class="label">
                <div class="label-semi-circle-part"></div>
                <div class="label-main-part" style="background-color: ${label.color}"></div>
            </div>
        `;
    }

    /*
    * @param project: array for the projects to be rendered
    */
    render(projects) {
        this.target.innerHTML = "";

        for(const project of projects) {
            if(project.active) {
                let cardHtml = `
                    <div class="card">
                        <div class="card-front">
                            <div class="card-content">
                                <a href=${project.url}>
                                    <img src=${project.imageUrl} />
                                </a>
                            </div>
                            <div class="button-container">
                                <button onclick="flipCard(this)">More Details</button>
                            </div>
                        </div>
                        <div class="card-back">
                            <div class="card-content">
                                <h3 class="card-title">${project.title}</h3>
                                <p class="card-details">${project.description}</p>
                                <div class="card-labels-section">
                                    <p>Tags:</p>
                                    <div class="labels-row">
                                        ${ project.labels
                                        .map((label) => this.createLabel(label))
                                        .reduce((acc, curr) => (acc + curr), "") }
                                    </div>
                                </div>
                            </div>
                            <div class="button-container">
                                <button onclick="flipCard(this)">Back</button>
                            </div>
                        </div>
                    </div>
                `;

                this.target.innerHTML += cardHtml;
            }
        }
    }

    update(projects) {

    }
}