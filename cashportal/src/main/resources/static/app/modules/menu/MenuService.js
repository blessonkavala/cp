(function() {
	'use strict';
    angular
        .module('app.core')
        .factory('MenuService', MenuService);

    /* @ngInject */
    function MenuService($http) {
    var service = {
        getUserMenu: getUserMenu
    };
    return service;
    
    function getUserMenu(){
       return $http.get('/usermenus').then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
    
}
})();