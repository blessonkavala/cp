(function() {
	'use strict';
    angular
        .module('app.user')
        .factory('UserService', UserService);

    /* @ngInject */
    function UserService($http) {
    var service = {
        getUserDetails: getUserDetails,
        getUserList: getUserList,
        getStatusList: getStatusList
    };
    return service;
    
    function getUserDetails(rid){
       return $http.post('/user/query', {rid:rid}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
    function getUserList(orgId) {
        return $http.post('/user/list', {orgId:orgId}).then(getCompleteHandler);
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
}
})();