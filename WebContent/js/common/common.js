/**
 *
 */

  /**
   * Preloader
   */
let preloader = document.querySelector('#preloader');
if (preloader) {
  console.log("preloader loading");
  window.addEventListener('load', () => {
    preloader.remove();
  });
}