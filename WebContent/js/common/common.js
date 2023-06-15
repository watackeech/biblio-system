/**
 *
 */

  /**
   * Preloader
   */
  let preloader = select('#preloader');
  if (preloader) {
  console.log("preloader loading");
    window.addEventListener('load', () => {
      preloader.remove()
    });
  }