# Portfolio

## Introduction

    Hello Developers. I am `Abhisek Mohanty` a full stack java developer. I have spent two years learning so many things
    related to programming and java. Now it's the time to implement the things what I have learned. And I am begining my 
    production journey with My Portfolio website. I will further develop this project as much time I use it.
> Visit my [website](https://coderabhisek.onrender.com)
 
## Ideology
This whole system how it is done is known as `SpringMVC`. I have so many choices to build this website with like `React`,
`Angular` and other frontend frameworks, which is okay because in portfolio website it is important that there should be a 
great frontend. The only reason I have made this website using spring mvc is It is loosely coupled. Whenever I want to make 
change in this website, It will be easy for me. On my website, I am generating so much dynamic content like my projects, education,
skills, languages and form handling. These things are handled by an application at backend, so I don't need to maintain this
stuff. If I want to add some skills and Projects, then I don't need to do any change in frontend, I will just add the project 
from my dashboard, and It will be saved to a database and visible at my frontend.

## How is this project done?
* I have followed the basic Industrial approach. First controller, then service and then repository layer and below their database exist.
* First of all I have created my cluster on `Mongodb Atlas`. I connected that cluster to my `Mongodb Compas` so that everything will be
  available for me locally. Then I have configured mongodb credentials with my application.
* Then I have built all my required models, respective repository and service classes. To handle all situations I have created some custom 
  exception classes and handlers.
* Everything from backend is all set.
  Now It's time for frontend.
  I went to bootstrap and downloaded the styles and required assets and started 
  building frontend.
* Then I have created layout of my frontend [`base.html`](./src/main/resources/templates/base.html). Then just created controller and the pages
  one by one. Any other form submission and validation is done along with that.
* Finally, containerized the application with `Docker`.
  I have a raw project and during the containerization I have configured everything such a 
  way that the `Application` will be created during the docker build.
  Check out [`Dockerfile`](./Dockerfile) for better understanding.
* During deployment
    
To build
```shell
docker build -t applicationname .
```
To run
```shell
docker run -p 8080:8080 applicationname
```

