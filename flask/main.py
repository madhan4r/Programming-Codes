from flask import Flask, render_template
from markupsafe import escape


app = Flask(__name__)


@app.route("/")
def hello_world():
    return render_template('home.html', title='test')


@app.route("/<name>")
def hello(name):
    return f"Hello, {escape(name)}!"


@app.route('/post/<int:post_id>')
def show_post(post_id):
    # show the post with the given id, the id is an integer
    return f'Post {post_id}'
