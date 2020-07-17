class LabelListRenderer extends RendererInterface {
    /*
    * @param targetElement -> DOM element
    */
    constructor(targetElement) {
        super();

        this.target = targetElement;
    }

    render(labels) {
        this.target.innerHTML = "";

        for(const label of labels) {
            let labelHtml = `
                <li>
                    <div class="label">
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