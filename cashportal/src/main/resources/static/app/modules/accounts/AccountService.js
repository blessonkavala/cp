(function() {
	'use strict';
    angular
        .module('app.accounts')
        .factory('AccountService', AccountService);

    /* @ngInject */
    function AccountService($http) {
    var service = {
        getCustomerAccounts: getCustomerAccounts,
        getCustomerAccountDetails: getCustomerAccountDetails
    };
    return service;
    
    function getCustomerAccounts(orgId){
       return $http.post('/customeraccount/list', {customerOrgId:orgId}).then(getCompleteHandler);

        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
       
    }
    
    function getCustomerAccountDetails(customerAccountId){
       return $http.post('/customeraccount/query', {rid:customerAccountId}).then(getCompleteHandler);
        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
    }
    
}
})();