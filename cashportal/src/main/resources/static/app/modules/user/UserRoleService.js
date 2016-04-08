(function() {
	'use strict';
    angular
        .module('app.user')
        .factory('UserRoleService', UserRoleService);

    /* @ngInject */
    function UserRoleService($http) {
    var service = {
        getUserRoles: getUserRoles
       
    };
    return service;
    
    function getUserRoles(userId){
       return $http.post('/userroles/query', {rid:userId}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
}
})();