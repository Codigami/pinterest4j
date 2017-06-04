# pinterest4j
**_pinterest4j_** is a Pinterest API library for the Java language licensed under Apache License 2.0.

**_Contributors:_**
- [Aniket Divekar](https://github.com/asdivekar)

# How to use

    // using default configurations
    Pinterest pinterestObj = new PinterestImpl(new ConfigurationBcImpl(), new OAuth2Token("<access-token>"));
    User user = pinterestObj.getUser("<username>");
