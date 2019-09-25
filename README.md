# jsonified - A JSON reader, writer and downloader for the CustomNPC's API
## How to use
```
    var spiderClass = Java.type("org.baito.forge.jsonified.Spider");
```
Place this line of code at the start of any code you need to access JSON files.
After inserted, you can create a "Spider", which crawls through the /config directory of the client or server.
You can also give a String to the constructor to a specific Path or File.
```
    var spider = new spiderClass();
    var otherSpider = new spiderClass("jsonified\\json");
```
Every Spider you create holds their own path that they're currently in, meaning you can have multiple Spider's crawling through. 

**Instance methods:**

    in(String directory) - Enter a folder.
    
    out() - Exits the folder.
    
    list() - Returns an array of all items.
    
    listFiles() - Returns an array of all files.
    
    get(String file) - Returns a JSONObject of the file you specify.
    
    exists(String file) - Returns whether the file exists.
    
    create(String name, boolean overwrite, String content) - Create a new file with the name specified and the 
    content specified. If the file already exists, you can overwrite it.
    
    urlCreate(String name, boolean overwrite, String url) - Create a new file with the name specified 
    and the content at the website provided. Very useful for creating files using online links from myjson.com
    
    NOTE: Pastebin is not supported currently, as Pastebin requires a Developer API Key to scrape from their site.
    
