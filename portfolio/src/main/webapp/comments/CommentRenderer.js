
class CommentRenderer extends RendererInterface {
    constructor(targetElement) {
        super();

        this.target = targetElement;
    }

    /**
     * Renders content on the comment section.
     * @param comments an array with the comment details to be rendered
     */
    render(comments) {
        this.target.innerHTML = "";

        for(const comment of comments) {
            let commentHTML = `
                <div class="comment-container">
                    <div class="comment-header">
                        <p class="comment-name">${comment.name}</p>
                        <div class="comment-header-bullet-seperator"></div>
                        <p class="comment-date">${comment.postDate}</p>
                    </div>
                    <div class="comment-body">
                        <p class="comment-desc">${comment.description}</p>
                    </div>
                </div>
            `;

            this.target.innerHTML += commentHTML;
        }
    }
}
