'use strict';

// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// AngularJS Chat Configuration
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
angular.module('chat').constant( 'config', {
    //
    // Get your API Keys -> https://www.pubnub.com/get-started/?medium=sbng2016&source=sbng2016&campaign=sbng2016&keyword=sbangularjs&content=sbng2016
    //
    "pubnub": {
        "publish-key"   : "pub-c-680aa730-bac9-4aa3-bc12-abf1aa9d2d6e",
        "subscribe-key" : "sub-c-4498d182-5ac8-11e6-aafa-02ee2ddab7fe"
    }
} );
