# lib-browsersync
Listen for node events (creating, updating and deleting) from **Enonic XP** and trigger a browsersync reload *if server is running with __dev__ flag*

## Usage

In your gradle.build file add TINEs repository to the repository list:
```
repositories {
	maven {
		url 'https://trm.tine.no/nexus/content/repositories/enonic-xp/'
	}
}
```

After this, add the following dependency (where ``<version>`` is the actual version to use):

```
dependencies {
	include 'no.tine.xp:xp-lib-browsersync:<version>'
}
```

Then start the server with the **dev** flag ([Enonic XP Development mode](http://xp.readthedocs.io/en/stable/developer/projects/devmode.html#gradle-dev-mode))

You will quite obviously also need to have [browsersync](https://www.browsersync.io/) up and running.

## Example

Install Browsersync from npm using:
`npm install -g browser-sync`

Start Browsersync proxying Enonic.
`browser-sync start --proxy 'localhost:8080'`

Navigate to your project page or preview with something like this:
`http://localhost:3000/admin/portal/preview/draft/sitename`

Do a change on the content and Browsersync will perform a reload of the page.

### Pro tip

Make Browsersync watch files aswell, it will then hotreload resources that it can and otherwise perform a full reload keeping the scroll position. This works great when chaning templates!

This example listens for changes in your projects assets directory, schemas, controllers and templates (Freemarker):
```
browser-sync start --proxy 'localhost:8080' --files 'src/**/assets/**/*.css' 'src/**/assets/**/*.js' 'src/**/*.ftl' 'src/**/*.xml' 'src/**/*.js'
```
