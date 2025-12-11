const world = 'world';

export function hello(who: string = world): string {
  return `Hello ${who}! `;
}

// in place sort
export function heapify(got: number[]): number[] {
  return got;
}

function siftDown(arr: number[], i: number, bound: number) {
  let largest = i;
  let left = 2 * i + 1;

}
