(function() {
	'use strict';
    angular
        .module('app.fundtransfer')
        .factory('FundTransferService', FundTransferService);

    /* @ngInject */
    function FundTransferService($http) {
    var service = {
        getNewInternalFundtransfer: getNewInternalFundtransfer,
        getPendingFundTransfers: getPendingFundTransfers
    };
    return service;
    
    function getNewInternalFundtransfer(){
       return $http.get('/ft/new').then(getCompleteHandler);
        function getCompleteHandler(response) {
            console.log(response);
            return response.data;
        }
    }
    
    function getPendingFundTransfers(tnxStatCode) {
        return $http.get('/ft/list', {tnxStatCode:tnxStatCode}).then(getCompleteHandler);
            function getCompleteHandler(response) {
                return response.data;
            }
    }
}
})();