(load "unit-test.lisp")

(load "code.lisp")

(defvar +steps+ '(
                  (0 (0 3 0 1 -3))
                  (0 (1 3 0 1 -3))
                  (1 (2 3 0 1 -3))
                  (4 (2 4 0 1 -3))
                  (1 (2 4 0 1 -2))
                (nil (2 5 0 1 -2))
                  ))

(deftest test-next-offset ()
  (check
   (equal (apply #'next-offset (nth 0 +steps+)) (nth 1 +steps+))
   (equal (apply #'next-offset (nth 1 +steps+)) (nth 2 +steps+))
   (equal (apply #'next-offset (nth 2 +steps+)) (nth 3 +steps+))
   (equal (apply #'next-offset (nth 3 +steps+)) (nth 4 +steps+))
   (equal (apply #'next-offset (nth 4 +steps+)) (nth 5 +steps+))))

(deftest test-count-steps ()
  (check
   (eq 5 (count-steps 0 '(0 3 0 1 -3)))
   (eq 10 (count-steps 0 '(0 3 0 1 -3) #'next-value-part-2))))

(deftest test-suite ()
  (combine-results
   (test-next-offset)
   (test-count-steps)))
