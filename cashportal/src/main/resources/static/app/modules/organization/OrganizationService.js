(function() {
	'use strict';
    angular
        .module('app.organization')
        .factory('OrganizationService', OrganizationService);

    /* @ngInject */
    function OrganizationService($http) {
    var service = {
        getOrganizationDetails: getOrganizationDetails,
        getOrganizationList: getOrganizationList,
        getStatusList: getStatusList,
        getLegalIDTypes: getLegalIDTypes
    };
    return service;
    
    function getOrganizationDetails(rid){
       return $http.post('/organization/query', {rid:rid}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
    function getOrganizationList() {
            return $http.get('/organization/list').then(getCompleteHandler);
                function getCompleteHandler(response) {
                    return response.data;
                }
    }
    
    function getStatusList() {
        var statusCodes = [
            {'code': 'A', 'value': 'Active'},
            {'code': 'I', 'value': 'Inactive'},
            {'code': 'D', 'value': 'Deleted'}
        ];
        return statusCodes;
    }
    
    function getLegalIDTypes(){
        var legalIDTypeCodes = [
           {'code': 'P', 'value': 'Passport'},
           {'code': 'A', 'value': 'Adhaar Card'},  
        ];
        return legalIDTypeCodes;
    }
}
})();