
// Renders the HTML on the render list on the menu
class LabelListRenderer extends RendererInterface {
    /*
    * @param targetElement: the appropriate DOM element
    */
    constructor(targetElement) {
        super();

        this.target = targetElement;
    }

    /*
    * @param labels: array for the labels to be rendered
    */
    render(labels) {
        this.target.innerHTML = "";

        for(const label of labels) {
            let labelHtml = `
                <li onclick="handleLabelClick(${label.id})">
                    <div class="label ${ label.active ? "label-active" : "" }">
                        <div class="label-semi-circle-part"></div>
                        <div class="label-main-part" style="background-color: ${label.color}"></div>
                    </div>
                    <p class="label-name">${label.name}</p>
                </li>
            `;

            this.target.innerHTML += labelHtml;
        }
    }
}