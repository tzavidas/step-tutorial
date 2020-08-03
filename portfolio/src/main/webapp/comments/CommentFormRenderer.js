class CommentFormRenderer extends RendererInterface {
    constructor(targetElement) {
        super();

        this.targetElement = targetElement;
    }

    render(hasUser) {
        if(hasUser) {
            this.targetElement.innerHTML = `
                <h2>New Comment</h2>
                <form onsubmit="handlePostCommentFormSubmit(event)">
                    <div class="comment-name-group">
                        <label for="comment-name">Name:</label>
                        <input name="comment-name" required />
                    </div>
                    <div class="comment-description-group">
                        <label for="comment-description">Text:</label>
                        <textarea name="comment-description" required /></textarea>
                    </div>
                    <div class="comment-file-upload-section">
                        <label for="comment-images">Upload Images:</label>
                        <input name="comment-images" type="file" multiple />
                    </div>
                    <button class="comment-post-form-submit-button">Submit</button>
                </form>
            `;
        } else {
            this.targetElement.innerHTML = `
                <h2>New Comment</h2>
                <p class="new-comment-not-allowed">
                    You need to login before posting any comments!
                </p>
            `;
        }
    }
}
