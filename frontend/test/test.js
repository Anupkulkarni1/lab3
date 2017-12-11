/**
 * Created by Anup.
 */
var request = require('request')
    , express = require('express')
    ,assert = require("assert")
    ,http = require("http");

describe('http tests', function(){

    it('should return the user', function(done){
        http.get('http://localhost:3001/getUser', function(res) {
            assert.equal(200, res.statusCode);
            done();
        })
    });

    it('should login if the url is correct', function(done){
        request.post(
            'http://localhost:3001/login',
            { form: { username: 'even@gmail.com',password:'even@gmail.com' } },
            function (error, res, body) {
                assert.equal(200, res.statusCode);
                done();
            }
        );
    });

    it('should logout', function(done) {
        request.post(
            'http://localhost:3001/logout',
            { form: { username: 'demo',password:'demo' } },
            function (error, res, body) {
                assert.equal(200, res.statusCode);
                done();
            }
        );
    });

    it('should delete the file', function(done) {
        request.post(
            'http://localhost:3001/deleteFile',
            { form: { username: 'demo',password:'demo' } },
            function (error, res, body) {
                assert.equal(200, res.statusCode);
                done();
            }
        );
    });

    it('should share the file', function(done) {
        request.post(
            'http://localhost:3001/shareFile',
            { form: { username: 'demo',password:'demo' } },
            function (error, res, body) {
                assert.equal(200, res.statusCode);
                done();
            }
        );
    });

    it('should star the file', function(done) {
        request.post(
            'http://localhost:3001/starFile',
            { form: { username: 'demo',password:'demo' } },
            function (error, res, body) {
                assert.equal(200, res.statusCode);
                done();
            }
        );
    });
});