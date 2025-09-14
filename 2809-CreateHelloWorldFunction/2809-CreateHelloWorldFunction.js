// Last updated: 9/14/2025, 9:08:03 AM
/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World"; 
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */