var ejs= require('ejs');
var mysql = require('mysql');

//Put your mysql configuration settings - user, password, database and port
var pool = mysql.createPool({

    host     : 'localhost',
    user     : 'root',
    password : 'anup',
    database : 'test',
    port	 : 3306
});

function getConnection()
{
    var connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'anup',
        database : 'test',
        port	 : 3306
    });
    return connection;
}



function fetchData(callback,sqlQuery) {

    console.log("\nSQL Query::" + sqlQuery);


    pool.getConnection(function (err, connection) {

        if (err) {
            connection.release;
            return;
        }
        connection.query(sqlQuery, function (err, rows, fields) {
            if (err) {
                console.log("ERROR: " + err.message);
            }
            else {	// return err or result
                console.log("DB Results:" + rows);
                callback(err, rows);
            }

            console.log("\nConnection closed..");
        });
    });
}



function persitData(callback,data) {

    console.log("\ndata::" + data);

    pool.getConnection(function(err,connection){

        if(err){
            connection.release;
            return;
        }


    var query = connection.query(data, function (err, result) {

        if (err) {
            console.log("ERROR: " + err.message);
        }
        else {
            callback(err, result);
        }

    });
    console.log(query.sql);

    console.log("\nConnection closed..");
    });
}

exports.fetchData=fetchData;
exports.persitData=persitData;


