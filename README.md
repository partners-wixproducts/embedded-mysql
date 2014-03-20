 [![Build Status](https://travis-ci.org/wix/embedded-mysql.svg)](https://travis-ci.org/wix/embedded-mysql)

Overview
========
This is a library that starts up (and stops, and cleans up after itself) a mysqld process on the local machine, for usage in integration tests.

Getting Started
===============
TODO when released to Maven Central

Usage
=====
Create a new instance of `EmbeddedMySql`. Typically you'll want to make this a singleton, like so:

```scala
object MySql extends EmbeddedMySql()
```

To connect to the DB (for instance, for creating fixtures), call `MySql.dataSource`, which connects to the initial DB name, or `MySql.dataSourceFor(dbName)` which connects to the specified DB.

Caveats
=======
 * Not tested on Windows machines and would probably not work properly.

Credits
=======
 * [Yoav Abrahami](https://github.com/yoavaa) for initially coming up with the idea back in 2011
 * [Groupon](https://github.com/groupon/mysql-junit4) for demonstrating it's possible to gracefully stop the mysql daemon

Roeadmap
========
Migration integration