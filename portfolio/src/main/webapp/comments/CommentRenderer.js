
class CommentRenderer extends RendererInterface {
    constructor(targetElement) {
        super();

        this.target = targetElement;
    }

    fillWithZeros(number, width) {
        const numberAsString = number.toString(10);

        if(width <= numberAsString.length) {
            return numberAsString;
        } else {
            const repitions = width - numberAsString.length;

            return ('0'.repeat(repitions)) + numberAsString;
        }
    }

    /**
     * formats a Date object
     * @param {Date} date the Date to be formatted
     * @returns {string} the formatted string adhering to "DD:MM:YYYY at HH:MM"
     */
    formatDate(date) {
        const formatted = this.fillWithZeros(date.getDate(), 2) + '/'
            + this.fillWithZeros(date.getMonth() + 1, 2) + '/' // month is 0-indexed
            + (1900 + date.getYear()) + ' at ' // year starts at 1900, so we need to add it
            + this.fillWithZeros(date.getHours(), 2) + ':'
            + this.fillWithZeros(date.getMinutes(), 2);

        return formatted;
    }

    /**
     * Renders content on the comment section.
     * @param comments an array with the comment details to be rendered
     */
    render(comments) {
        this.target.innerHTML = '';

        if(comments.length == 0) {
            const emptyCommentHtml = `
                <div class="comment-container">
                    <p>No comments to display!</p>
                </div>
            `;

            this.target.innerHTML = emptyCommentHtml;
        } else {
            for(const comment of comments) {
                const postDate = new Date(comment.postDate);

                let commentHTML = `
                    <div class="comment-container">
                        <div class="comment-header">
                            <p class="comment-name">${comment.name}</p>
                            <div class="comment-header-bullet-seperator"></div>
                            <p class="comment-date">${this.formatDate(postDate)}</p>
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
}
