<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->

<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Tizios9999/glitchreporter-backend">
    <img src="https://www.kindpng.com/picc/m/160-1608792_circle-document-icon-png-transparent-png.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Glitch Reporter (Backend service)</h3>

  <p align="center">
    The frontend interface of GlitchReporter, my ticket management app.
    <br />
    <a href="https://github.com/Tizios9999/meditation-app"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://glitchreporter-backend-fc42.vercel.app/">View Demo</a>
    ·
    <a href="https://github.com/Tizios9999/glitchreporter-backend/issues">Report Bug</a>
    ·
    <a href="https://github.com/Tizios9999/glitchreporter-backend/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

GlitchReporter is a complete software application that helps tracking and managing customer support requests. It allows customers to create tickets to report problems or ask questions, and it provides agents with a centralized view of all tickets.

This is the backend service, you have to start this service locally first to access the visual interface.

IMPORTANT!
To be able to run this service, you will need a file with the environment variables. Feel free to contact me to obtain it.

You can find the repository of the frontend interface <a href="https://github.com/Tizios9999/glitch-reporter-frontend/">here</a>.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

- JAVA 19
- Maven
- Spring Boot (Spring Data JPA, Security, Web)
- MySQL
- Docker

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

### Prerequisites

- Environment variables (.env) file: please contact me to obtain it.
- Docker: This backend service runs on a Docker Container. You can download it <a href="https://docs.docker.com/get-docker/">here</a> and follow the instructions on how to use it.

### Installation

Place the .env file in a folder of your choice. Open a terminal in that folder (CMD or PoweShell in Windows, Bash in Linux etc).

From that folder, pull the Docker image from the Docker registry.

```sh
docker pull tizios9999/glitchreporter
```

Once you downloaded the image, you can run the service in a Docker container.

```sh
docker run -p 8080:8080 --env-file .env tizios9999/glitchreporter
```

Now the service should be up and running at the address: http://localhost:8080.

You can finally access the frontend interface by going to: <a href="https://glitch-reporter-frontend-fc42.vercel.app/">https://glitch-reporter-frontend-fc42.vercel.app/</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->

## Usage

Instructions on how to use the frontend interface are on their respective repo <a href="https://github.com/Tizios9999/glitch-reporter-frontend/">here</a>.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->

## Roadmap of possible future releases

- [x] Release the first working version
- [ ] Online container deployment.

See the [open issues](https://github.com/Tizios9999/glitchreporter-backend/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->

## Contributing

This is a course project aimed to evaluate my personal skills, so right now it's closed for contributions. Any advice is always kindly appreciated though! You can even submit them directly on my app! :D

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

Davide Santonocito - davide.santonocito@outlook.com

Project Link: [https://github.com/Tizios9999/glitchreporter-backend](https://github.com/Tizios9999/glitchreporter-backend)

Live at: [https://glitch-reporter-frontend-fc42.vercel.app/](https://glitch-reporter-frontend-fc42.vercel.app/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-url]: https://github.com/Tizios9999/glitchreporter-backend/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Tizios9999/meditation-app.svg?style=for-the-badge
[forks-url]: https://github.com/Tizios9999/glitchreporter-backend/network/members
[stars-shield]: https://img.shields.io/github/stars/Tizios9999/meditation-app.svg?style=for-the-badge
[stars-url]: https://github.com/Tizios9999/glitchreporter-backend/stargazers
[issues-shield]: https://img.shields.io/github/issues/Tizios9999/meditation-app.svg?style=for-the-badge
[issues-url]: https://github.com/Tizios9999/glitchreporter-backend/issues
[license-shield]: https://img.shields.io/github/license/Tizios9999/meditation-app.svg?style=for-the-badge
[license-url]: https://github.com/Tizios9999/glitchreporter-backend/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/davide-santonocito-36ab84170
