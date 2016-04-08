(function() {
	'use strict';
    angular
        .module('app.organization')
        .factory('OrganizationRoleService', OrganizationRoleService);

    /* @ngInject */
    function OrganizationRoleService($http) {
    var service = {
        getOrganizationRoles: getOrganizationRoles
       
    };
    return service;
    
    function getOrganizationRoles(orgId){
       return $http.post('/orgroles/query', {rid:orgId}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
}
})();