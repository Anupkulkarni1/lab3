var ejs = require("ejs");
var mysql = require('./mysql');
var bcrypt= require('bcrypt');

var express = require('express');


var app = express();



var express=require("express");




function signin(req,res) {

	ejs.renderFile('./views/signin.ejs',function(err, result) {
	   // render on success
	   if (!err) {
	            res.end(result);
	   }
	   // render or error
	   else {
	            res.end('An error occurred');
	            console.log(err);
	   }
   });
}


function afterSignIn(req,res)
{
	// check user already exists
	var getUser="select * from users where username='"+req.param("inputUsername")+"'";
	console.log("Query is:"+getUser);
	
	mysql.fetchData(function(err,results){
		if(err){
			throw err;
		}
		else 
		{
			if(results.length > 0 && bcrypt.compareSync(req.param("inputPassword"),results[0].password)){
				console.log("valid Login");

				ejs.renderFile('./views/successLogin.ejs', { data: results } , function(err, result) {
			        // render on success
			        if (!err) {
			            res.end(result);
			        }
			        // render or error
			        else {
			            res.end('An error occurred');
			            console.log(err);
			        }
			    });
			}
			else {    
				
				console.log("Invalid Login");
				ejs.renderFile('./views/failLogin.ejs',function(err, result) {
			        // render on success
			        if (!err) {
			            res.end(result);
			        }
			        // render or error
			        else {
			            res.end('An error occurred');
			            console.log(err);
			        }
			    });
			}
		}  
	},getUser);
}

function getAllUsers(req,res)
{
	var getAllUsers = "select * from users";
	console.log("Query is:"+getAllUsers);
	
	mysql.fetchData(function(err,results){
		if(err){
			throw err;
		}
		else 
		{
			if(results.length > 0){
				
				var rows = results;
				var jsonString = JSON.stringify(results);
				var jsonParse = JSON.parse(jsonString);
				
				console.log("Results Type: "+(typeof results));
				console.log("Result Element Type:"+(typeof rows[0].emailid));
				console.log("Results Stringify Type:"+(typeof jsonString));
				console.log("Results Parse Type:"+(typeof jsString));
				
				console.log("Results: "+(results));
				console.log("Result Element:"+(rows[0].emailid));
				console.log("Results Stringify:"+(jsonString));
				console.log("Results Parse:"+(jsonParse));
				
				ejs.renderFile('./views/successLogin.ejs',{data:jsonParse},function(err, result) {
			        // render on success
			        if (!err) {
			            res.end(result);
			        }
			        // render or error
			        else {
			            res.end('An error occurred');
			            console.log(err);
			        }
			    });
			}
			else {    
				
				console.log("No users found in database");
				ejs.renderFile('./views/failLogin.ejs',function(err, result) {
			        // render on success
			        if (!err) {
			            res.end(result);
			        }
			        // render or error
			        else {
			            res.end('An error occurred');
			            console.log(err);
			        }
			    });
			}
		}  
	},getAllUsers);
}


function signup(req,res) {

	ejs.renderFile('./views/signup.ejs',function(err, result) {
	   // render on success
	   if (!err) {
	            res.end(result);
	   }
	   // render or error
	   else {
	            res.end('An error occurred');
	            console.log(err);
	   }
   });
}

function afterSignUp(req,res)
{
	// check user already exists
	var post = {
    username: req.param("inputUsername"),
    password: req.param("inputPassword"),
    first_name: req.param("inputFname"),
    last_name: req.param("inputLname"),
    gender: req.param("gender"),
	dob: req.param("bday")
   };


	var usrNm = req.param("inputUsername");
	var pass = req.param("inputPassword");
	var fn = req.param("inputFname");
	var ln = req.param("inputLname");
	var dob = req.param("bday");
	var gen= req.param("gender");
	


	var sql = "INSERT INTO users (username, password, first_name, last_name, gender, dob) VALUES ('"+usrNm+"', '"+pass+"','"+req.param("inputFname")+"','"+req.param("inputLname")+"','"+req.param("gender")+"','"+req.param("bday")+"');";


	console.log(sql);


	//var persistUser="Insert into users values ?", post;
	//console.log("Query is:"+getUser);
	console.log(post);
	// console.log('username '+ req.param("inputUsername"));
		
	// console.log('password '+ req.param("inputPassword"));

	// console.log('first name '+ req.param("inputFname"));

	// console.log('Last Name '+ req.param("inputLname"));

	// console.log('dob '+ req.param("bday"));

	console.log('gender '+ req.param("gender"));
	mysql.persitData(function(err,results){
		if(err){
			throw err;
		}
		else
		{
				ejs.renderFile('./views/signin.ejs',function(err, result) 
				{
			   // render on success
			   if (!err) {
			            res.end(result);
			   }
			   // render or error
			   else {
			            res.end('An error occurred');
			            console.log(err);
			   }
		   });
		}
	},sql);

	
	// mysql.fetchData(function(err,results){
	// 	if(err){
	// 		throw err;
	// 	}
	// 	else 
	// 	{
	// 		if(results.length > 0){
	// 			console.log("valid Login");
	// 			ejs.renderFile('./views/successLogin.ejs', { data: results } , function(err, result) {
	// 		        // render on success
	// 		        if (!err) {
	// 		            res.end(result);
	// 		        }
	// 		        // render or error
	// 		        else {
	// 		            res.end('An error occurred');
	// 		            console.log(err);
	// 		        }
	// 		    });
	// 		}
	// 		else {    
				
	// 			console.log("Invalid Login");
	// 			ejs.renderFile('./views/failLogin.ejs',function(err, result) {
	// 		        // render on success
	// 		        if (!err) {
	// 		            res.end(result);
	// 		        }
	// 		        // render or error
	// 		        else {
	// 		            res.end('An error occurred');
	// 		            console.log(err);
	// 		        }
	// 		    });
	// 		}
	// 	}  
	// },getUser);
}



exports.signup=signup;
exports.signin=signin;
exports.afterSignIn=afterSignIn;
exports.getAllUsers=getAllUsers;
exports.afterSignUp=afterSignUp;
